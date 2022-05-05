USE [master]
GO
/****** Object:  Database [DemoLab]    Script Date: 2022/3/19 �U�� 01:44:45 ******/
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'DemoLab')
BEGIN
CREATE DATABASE [DemoLab]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DemoLab', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DemoLab.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DemoLab_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DemoLab_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
END
GO
ALTER DATABASE [DemoLab] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DemoLab].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DemoLab] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DemoLab] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DemoLab] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DemoLab] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DemoLab] SET ARITHABORT OFF 
GO
ALTER DATABASE [DemoLab] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DemoLab] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DemoLab] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DemoLab] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DemoLab] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DemoLab] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DemoLab] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DemoLab] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DemoLab] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DemoLab] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DemoLab] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DemoLab] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DemoLab] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DemoLab] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DemoLab] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DemoLab] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DemoLab] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DemoLab] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DemoLab] SET  MULTI_USER 
GO
ALTER DATABASE [DemoLab] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DemoLab] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DemoLab] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DemoLab] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DemoLab] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DemoLab] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'DemoLab', N'ON'
GO
ALTER DATABASE [DemoLab] SET QUERY_STORE = OFF
GO
ALTER DATABASE [DemoLab] SET  READ_WRITE 
GO