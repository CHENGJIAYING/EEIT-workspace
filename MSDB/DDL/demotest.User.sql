USE [DemoLab]
GO
/****** Object:  User [demotest]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
IF NOT EXISTS (SELECT * FROM sys.database_principals WHERE name = N'demotest')
CREATE USER [demotest] FOR LOGIN [demotest] WITH DEFAULT_SCHEMA=[dbo]
GO
