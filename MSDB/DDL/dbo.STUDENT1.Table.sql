USE [DemoLab]
GO
/****** Object:  Table [dbo].[STUDENT1]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[STUDENT1]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[STUDENT1](
	[st_no] [nvarchar](10) NOT NULL,
	[st_name] [nvarchar](20) NULL,
	[gender] [nvarchar](1) NULL,
	[birthday] [date] NULL,
	[city] [nvarchar](10) NULL,
	[address] [nvarchar](60) NULL,
 CONSTRAINT [PK_STUDENT1] PRIMARY KEY CLUSTERED 
(
	[st_no] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
