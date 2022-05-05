USE [DemoLab]
GO
/****** Object:  Synonym [dbo].[emp_syn]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
IF NOT EXISTS (SELECT * FROM sys.synonyms WHERE name = N'emp_syn' AND schema_id = SCHEMA_ID(N'dbo'))
CREATE SYNONYM [dbo].[emp_syn] FOR [employees]
GO
