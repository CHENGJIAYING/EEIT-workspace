USE [DemoLab]
GO
/****** Object:  User [demotest2]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
IF NOT EXISTS (SELECT * FROM sys.database_principals WHERE name = N'demotest2')
CREATE USER [demotest2] FOR LOGIN [demotest2] WITH DEFAULT_SCHEMA=[dbo]
GO
