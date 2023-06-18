-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18/06/2023 às 16:30
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `pousada`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `data_nacimento` date NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `cpf`, `rg`, `data_nacimento`, `sexo`, `telefone`, `status`) VALUES
(1, 'Marcos Everaldo', '123.456.789-09', '15645644', '2001-08-15', 'M', '5645645677', 1),
(2, 'Lucas', '987.654.321-00', '5674654', '1993-05-03', 'M', '564644054', 1),
(3, 'Paulo Almeida', '456.123.475-62', '1234516', '2000-12-10', 'M', '81933442502', 1),
(4, 'Alberto Jose', '987.654.321-01', '1234567', '2000-06-15', 'M', '99999-9999', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `fpag`
--

CREATE TABLE `fpag` (
  `id` int(11) NOT NULL,
  `descricao` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `fpag`
--

INSERT INTO `fpag` (`id`, `descricao`) VALUES
(1, 'PIX'),
(2, 'CARTAO'),
(3, 'CASH');

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `data_nacimento` date NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `rua` varchar(200) NOT NULL,
  `numero` varchar(11) NOT NULL,
  `bairro` varchar(200) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `senha` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `cpf`, `rg`, `data_nacimento`, `sexo`, `rua`, `numero`, `bairro`, `telefone`, `senha`) VALUES
(3, 'jose', '123.456.789-09', '156456', '1991-02-01', 'F', 'sdgsdg', '154564', 'srghwgh', '454654', 'd41d8cd98f00b204e9800998ecf8427e'),
(5, 'Amanda', '123.456.789-09', '464655556', '1990-02-01', 'M', 'werghwhg', 'wrehe', 'qwehe', 'erh', 'e10adc3949ba59abbe56e057f20f883e'),
(7, 'Joao', '987.654.321-00', '45648423', '1985-10-25', 'M', 'Rua da Alegria', '55', 'Centro', '996334428', '81dc9bdb52d04dc20036dbd8313ed055');

-- --------------------------------------------------------

--
-- Estrutura para tabela `quarto`
--

CREATE TABLE `quarto` (
  `id` int(11) NOT NULL,
  `num_quarto` varchar(6) NOT NULL,
  `tipo` varchar(15) NOT NULL,
  `descricao` varchar(800) NOT NULL,
  `valor` double(5,2) NOT NULL,
  `status` int(11) NOT NULL,
  `reservado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `quarto`
--

INSERT INTO `quarto` (`id`, `num_quarto`, `tipo`, `descricao`, `valor`, `status`, `reservado`) VALUES
(1, '1', 'Duplo Casal', 'Cama de casal, televisão, frigobar.', 135.00, 1, 0),
(2, '2', 'Duplo Solteiro', '2 camas de solteiro, televisão,\nfrigobar.\n.', 135.00, 1, 0),
(3, '3', 'Duplo Casal', 'Cama casal, frigobar,\n ar condicionado, televisao', 150.00, 1, 1),
(4, '4', 'Triplo Casal', '1 Cama de solteiro e  1 cama\nde casal, televisao, ar condicionado', 175.00, 1, 0),
(5, '5', 'Triplo Solteiro', '3 camas de solteir, frigobar\nar condicionado, televisao', 190.00, 1, 0),
(6, '6', 'Single', '1 cama de solteiro, frigobar, ar condicionado', 125.00, 1, 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `reserva`
--

CREATE TABLE `reserva` (
  `id` int(11) NOT NULL,
  `data_entrada` date NOT NULL,
  `data_saida` date NOT NULL,
  `data_reserva` date NOT NULL DEFAULT current_timestamp(),
  `cliente_id` int(11) NOT NULL,
  `quarto_id` int(11) NOT NULL,
  `fpag_id` int(11) NOT NULL,
  `valor` double(10,2) NOT NULL,
  `observacoes` varchar(800) DEFAULT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `reserva`
--

INSERT INTO `reserva` (`id`, `data_entrada`, `data_saida`, `data_reserva`, `cliente_id`, `quarto_id`, `fpag_id`, `valor`, `observacoes`, `status`) VALUES
(5, '2023-05-20', '2023-05-22', '2023-05-20', 1, 1, 1, 235.00, 'syseyh', 'Finalizada'),
(7, '2023-05-27', '2023-05-28', '2023-05-26', 2, 2, 2, 350.00, 'tjeue5ue', 'Finalizada'),
(8, '2023-05-26', '2023-05-28', '2023-05-26', 1, 1, 2, 1000.00, 'wegwegwe', 'Finalizada'),
(10, '2023-05-27', '2023-05-29', '2023-05-26', 1, 3, 3, 350.00, 'wfqawfqawf', 'Cancelada'),
(13, '2023-05-20', '2023-05-28', '2023-05-26', 2, 1, 2, 135.00, '3tywyw4y', 'Cancelada'),
(14, '2023-05-20', '2023-05-22', '2023-05-26', 2, 3, 2, 135.00, 'aawfawfaf', 'Finalizada'),
(16, '2023-05-28', '2023-06-03', '2023-05-27', 1, 3, 3, 900.00, '', 'Cancelada'),
(21, '2023-05-23', '2023-05-25', '2023-05-27', 1, 3, 3, 300.00, '', 'Finalizada'),
(23, '2023-10-25', '2023-11-30', '2023-05-27', 1, 3, 1, 5400.00, 'isso', 'Cancelada'),
(24, '2023-05-23', '2023-05-28', '2023-05-27', 1, 3, 1, 750.00, '', 'Finalizada'),
(25, '2023-05-26', '2023-05-27', '2023-05-27', 1, 2, 2, 135.00, '', 'Finalizada'),
(26, '2023-05-26', '2023-05-30', '2023-05-27', 1, 2, 3, 540.00, 'segsg', 'Finalizada'),
(27, '2023-05-11', '2023-05-12', '2023-05-28', 1, 4, 2, 175.00, '', 'Finalizada'),
(28, '2024-01-01', '2024-01-02', '2023-05-28', 1, 5, 1, 190.00, '', 'Cancelada'),
(29, '2023-05-30', '2023-06-18', '2023-05-28', 1, 3, 2, 2850.00, 'Tá caro demais', 'Reservada'),
(30, '2023-11-30', '2023-12-30', '2023-05-29', 1, 5, 1, 5700.00, '', 'Reservada'),
(31, '2023-11-26', '2023-11-30', '2023-06-13', 1, 3, 3, 600.00, 'dfbdfb', 'Reservada'),
(32, '2023-07-25', '2023-07-30', '2023-06-18', 1, 5, 3, 950.00, 'Pago', 'Reservada');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `fpag`
--
ALTER TABLE `fpag`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `quarto`
--
ALTER TABLE `quarto`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`),
  ADD KEY `fpag_id` (`fpag_id`),
  ADD KEY `quarto_id` (`quarto_id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `fpag`
--
ALTER TABLE `fpag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `quarto`
--
ALTER TABLE `quarto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`fpag_id`) REFERENCES `fpag` (`id`),
  ADD CONSTRAINT `reserva_ibfk_4` FOREIGN KEY (`quarto_id`) REFERENCES `quarto` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
