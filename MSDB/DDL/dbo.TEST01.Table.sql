USE [DemoLab]
GO
/****** Object:  Table [dbo].[TEST01]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TEST01]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[TEST01](
	[stno] [int] NULL,
	[stname] [char](10) NULL
) ON [PRIMARY]
END
GO
