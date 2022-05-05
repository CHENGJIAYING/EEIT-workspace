USE [DemoLab]
GO
/****** Object:  Table [dbo].[SALES_REPS]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[SALES_REPS]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[SALES_REPS](
	[id] [int] NOT NULL,
	[name] [nvarchar](25) NULL,
	[salary] [decimal](8, 2) NULL,
	[commission_pct] [decimal](2, 2) NULL
) ON [PRIMARY]
END
GO
