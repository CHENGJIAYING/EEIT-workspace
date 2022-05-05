USE [DemoLab]
GO
/****** Object:  User [demouser]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
IF NOT EXISTS (SELECT * FROM sys.database_principals WHERE name = N'demouser')
CREATE USER [demouser] FOR LOGIN [demouser] WITH DEFAULT_SCHEMA=[dbo]
GO
