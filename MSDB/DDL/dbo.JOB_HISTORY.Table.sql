USE [DemoLab]
GO
/****** Object:  Table [dbo].[JOB_HISTORY]    Script Date: 2022/3/19 ?U?? 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[JOB_HISTORY]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[JOB_HISTORY](
	[EMPLOYEE_ID] [int] NULL,
	[START_DATE] [datetime] NULL,
	[END_DATE] [datetime] NULL,
	[JOB_ID] [nvarchar](10) NULL,
	[DEPARTMENT_ID] [int] NULL
) ON [PRIMARY]
END
GO
/****** Object:  Index [JHIST_DEPARTMENT_IX]    Script Date: 2022/3/19 ?U?? 01:44:46 ******/
IF NOT EXISTS (SELECT * FROM sys.indexes WHERE object_id = OBJECT_ID(N'[dbo].[JOB_HISTORY]') AND name = N'JHIST_DEPARTMENT_IX')
CREATE NONCLUSTERED INDEX [JHIST_DEPARTMENT_IX] ON [dbo].[JOB_HISTORY]
(
	[DEPARTMENT_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [JHIST_EMPLOYEE_IX]    Script Date: 2022/3/19 ?U?? 01:44:46 ******/
IF NOT EXISTS (SELECT * FROM sys.indexes WHERE object_id = OBJECT_ID(N'[dbo].[JOB_HISTORY]') AND name = N'JHIST_EMPLOYEE_IX')
CREATE NONCLUSTERED INDEX [JHIST_EMPLOYEE_IX] ON [dbo].[JOB_HISTORY]
(
	[EMPLOYEE_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [JHIST_JOB_IX]    Script Date: 2022/3/19 ?U?? 01:44:46 ******/
IF NOT EXISTS (SELECT * FROM sys.indexes WHERE object_id = OBJECT_ID(N'[dbo].[JOB_HISTORY]') AND name = N'JHIST_JOB_IX')
CREATE NONCLUSTERED INDEX [JHIST_JOB_IX] ON [dbo].[JOB_HISTORY]
(
	[JOB_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[JHIST_DEPT_FK]') AND parent_object_id = OBJECT_ID(N'[dbo].[JOB_HISTORY]'))
ALTER TABLE [dbo].[JOB_HISTORY]  WITH CHECK ADD  CONSTRAINT [JHIST_DEPT_FK] FOREIGN KEY([DEPARTMENT_ID])
REFERENCES [dbo].[DEPARTMENTS] ([DEPARTMENT_ID])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[JHIST_DEPT_FK]') AND parent_object_id = OBJECT_ID(N'[dbo].[JOB_HISTORY]'))
ALTER TABLE [dbo].[JOB_HISTORY] CHECK CONSTRAINT [JHIST_DEPT_FK]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[JHIST_EMP_FK]') AND parent_object_id = OBJECT_ID(N'[dbo].[JOB_HISTORY]'))
ALTER TABLE [dbo].[JOB_HISTORY]  WITH CHECK ADD  CONSTRAINT [JHIST_EMP_FK] FOREIGN KEY([EMPLOYEE_ID])
REFERENCES [dbo].[EMPLOYEES] ([EMPLOYEE_ID])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[JHIST_EMP_FK]') AND parent_object_id = OBJECT_ID(N'[dbo].[JOB_HISTORY]'))
ALTER TABLE [dbo].[JOB_HISTORY] CHECK CONSTRAINT [JHIST_EMP_FK]
GO
IF NOT EXISTS (SELECT * FROM sys.check_constraints WHERE object_id = OBJECT_ID(N'[dbo].[JHIST_DATE_INTERVAL]') AND parent_object_id = OBJECT_ID(N'[dbo].[JOB_HISTORY]'))
ALTER TABLE [dbo].[JOB_HISTORY]  WITH CHECK ADD  CONSTRAINT [JHIST_DATE_INTERVAL] CHECK  (([end_date]>[start_date]))
GO
IF  EXISTS (SELECT * FROM sys.check_constraints WHERE object_id = OBJECT_ID(N'[dbo].[JHIST_DATE_INTERVAL]') AND parent_object_id = OBJECT_ID(N'[dbo].[JOB_HISTORY]'))
ALTER TABLE [dbo].[JOB_HISTORY] CHECK CONSTRAINT [JHIST_DATE_INTERVAL]
GO
