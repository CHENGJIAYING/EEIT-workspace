USE [DemoLab]
GO
/****** Object:  StoredProcedure [dbo].[usp_ExampleProc]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[usp_ExampleProc]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[usp_ExampleProc] AS' 
END
GO
-- Create a stored procedure that will cause an object resolution error.  
ALTER PROCEDURE [dbo].[usp_ExampleProc]  
AS  
  SELECT * FROM NonexistentTable;  
GO
