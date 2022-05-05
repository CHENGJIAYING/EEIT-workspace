USE [DemoLab]
GO
/****** Object:  Table [dbo].[BONUS]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BONUS]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[BONUS](
	[ENAME] [nvarchar](10) NULL,
	[JOB] [nvarchar](9) NULL,
	[SAL] [int] NULL,
	[COMM] [int] NULL
) ON [PRIMARY]
END
GO
