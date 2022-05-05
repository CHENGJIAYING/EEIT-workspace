USE [DemoLab]
GO
/****** Object:  Table [dbo].[SALGRADE]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[SALGRADE]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[SALGRADE](
	[GRADE] [int] NULL,
	[LOSAL] [int] NULL,
	[HISAL] [int] NULL
) ON [PRIMARY]
END
GO
