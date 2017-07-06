-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 01-Dez-2016 às 10:40
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `corretor`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `nome` varchar(15) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `usuario` varchar(10) NOT NULL,
  `senha` varchar(4) NOT NULL,
  `tipo_usuario` int(5) NOT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `administrador`
--

INSERT INTO `administrador` (`nome`, `cpf`, `usuario`, `senha`, `tipo_usuario`) VALUES
('Bernardo', '01254438629', 'be', '123', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `banco`
--

CREATE TABLE IF NOT EXISTS `banco` (
  `codigo` int(4) NOT NULL AUTO_INCREMENT,
  `razaoSocial` varchar(20) NOT NULL,
  `cnpj` varchar(20) NOT NULL,
  `endereco` varchar(20) NOT NULL,
  `numero` int(4) NOT NULL,
  `bairro` varchar(20) NOT NULL,
  `cidade` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `comprador`
--

CREATE TABLE IF NOT EXISTS `comprador` (
  `codigo` int(4) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `endereco` varchar(20) NOT NULL,
  `numero` int(4) NOT NULL,
  `bairro` varchar(20) NOT NULL,
  `cidade` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `corretor`
--

CREATE TABLE IF NOT EXISTS `corretor` (
  `codigo` int(4) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `senha` varchar(6) NOT NULL,
  `tipo_usuario` int(5) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `corretor`
--

INSERT INTO `corretor` (`codigo`, `nome`, `cpf`, `usuario`, `senha`, `tipo_usuario`) VALUES
(1, 'dede', '10063010623', 'eu', '12', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fiador`
--

CREATE TABLE IF NOT EXISTS `fiador` (
  `codigo` int(4) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `endereco` varchar(30) NOT NULL,
  `numero` int(4) NOT NULL,
  `bairro` varchar(20) NOT NULL,
  `cidade` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `imovel`
--

CREATE TABLE IF NOT EXISTS `imovel` (
  `codigo` int(5) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(15) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `endereco` varchar(50) NOT NULL,
  `numero` int(4) NOT NULL,
  `bairro` varchar(20) NOT NULL,
  `cidade` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `complemento` varchar(20) DEFAULT NULL,
  `valor` float NOT NULL,
  `status` int(15) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_usuario`
--

CREATE TABLE IF NOT EXISTS `tipo_usuario` (
  `id` int(5) NOT NULL,
  `descricao` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id`, `descricao`) VALUES
(1, 'administrador'),
(2, 'corretor');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendaereserva`
--

CREATE TABLE IF NOT EXISTS `vendaereserva` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codImovel` int(4) NOT NULL,
  `codComprador` int(4) NOT NULL,
  `codBanco` int(4) DEFAULT NULL,
  `codFiador` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
