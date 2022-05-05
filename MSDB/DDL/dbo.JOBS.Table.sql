USE [DemoLab]
GO
/****** Object:  Table [dbo].[JOBS]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[JOBS]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[JOBS](
	[JOB_ID] [nvarchar](10) NOT NULL,
	[JOB_TITLE] [nvarchar](35) NULL,
	[MIN_SALARY] [int] NULL,
	[MAX_SALARY] [int] NULL
) ON [PRIMARY]
END
GO
