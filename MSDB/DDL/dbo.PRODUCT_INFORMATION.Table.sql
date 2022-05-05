USE [DemoLab]
GO
/****** Object:  Table [dbo].[PRODUCT_INFORMATION]    Script Date: 2022/3/19 �U�� 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[PRODUCT_INFORMATION]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[PRODUCT_INFORMATION](
	[PRODUCT_ID] [int] NOT NULL,
	[PRODUCT_NAME] [nvarchar](50) NULL,
	[PRODUCT_DESCRIPTION] [nvarchar](2000) NULL,
	[CATEGORY_ID] [int] NULL,
	[WEIGHT_CLASS] [int] NULL,
	[WARRANTY_PERIOD] [nvarchar](10) NULL,
	[SUPPLIER_ID] [int] NULL,
	[PRODUCT_STATUS] [nvarchar](20) NULL,
	[LIST_PRICE] [decimal](8, 2) NULL,
	[MIN_PRICE] [decimal](8, 2) NULL,
	[CATALOG_URL] [nvarchar](50) NULL,
 CONSTRAINT [PRODUCT_INFORMATION_PK] PRIMARY KEY CLUSTERED 
(
	[PRODUCT_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Index [PROD_SUPPLIER_IX]    Script Date: 2022/3/19 �U�� 01:44:46 ******/
IF NOT EXISTS (SELECT * FROM sys.indexes WHERE object_id = OBJECT_ID(N'[dbo].[PRODUCT_INFORMATION]') AND name = N'PROD_SUPPLIER_IX')
CREATE NONCLUSTERED INDEX [PROD_SUPPLIER_IX] ON [dbo].[PRODUCT_INFORMATION]
(
	[SUPPLIER_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO