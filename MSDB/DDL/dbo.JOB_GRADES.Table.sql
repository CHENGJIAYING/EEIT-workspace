USE [DemoLab]
GO
/****** Object:  Table [dbo].[JOB_GRADES]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[JOB_GRADES]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[JOB_GRADES](
	[GRADE] [nvarchar](1) NULL,
	[LO_SAL] [int] NULL,
	[HI_SAL] [int] NULL
) ON [PRIMARY]
END
GO
