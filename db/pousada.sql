-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 03-Jun-2023 às 00:44
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 7.4.29

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
-- Estrutura da tabela `cliente`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `cpf`, `rg`, `data_nacimento`, `sexo`, `telefone`, `status`) VALUES
(1, 'Marcos Everaldo', '123.456.789-09', '15645644', '2001-08-15', 'M', '5645645677', 1),
(2, 'Lucas', '987.654.321-00', '5674654', '1993-12-25', 'M', '564644054', 1),
(3, 'Paulo Almeida', '456.123.475-62', '1234516', '2000-12-10', 'M', '81933442502', 0),
(4, 'Vitoria', '235.684.752-12', '3020154', '1988-09-15', 'F', '6543-0021', 1),
(5, 'Kabuto', '547.896.520-03', '1200365', '2005-02-01', 'M', '3628-8899', 1),
(6, 'Marcio', '023.224.558-95', '0367812', '1955-09-21', 'M', '0214-6521', 1),
(7, 'Emerson', '023.654.559-89', '5200123', '1940-09-06', 'M', '8569-1598', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fpag`
--

CREATE TABLE `fpag` (
  `id` int(11) NOT NULL,
  `descricao` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `fpag`
--

INSERT INTO `fpag` (`id`, `descricao`) VALUES
(1, 'PIX'),
(2, 'CARTAO'),
(3, 'CASH');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `cpf`, `rg`, `data_nacimento`, `sexo`, `rua`, `numero`, `bairro`, `telefone`, `senha`) VALUES
(5, 'Amanda', '123.456.789-09', '464655556', '1990-02-01', 'F', 'Rua da Gaia', '564', 'Joao Enersto', '8512-8965', '202cb962ac59075b964b07152d234b70'),
(8, 'João', '562.341.789-56', '1546987', '1985-05-12', 'M', 'Rua Dra Maria', '87', 'Caipirinha', '8565-1235', 'c20ad4d76fe97759aa27a0c99bff6710'),
(9, 'Pedro', '542.136.958-75', '3965874', '2000-01-23', 'M', 'Rua Santo Antonio', '2', 'Boa Vista', '5568-7458', '202cb962ac59075b964b07152d234b70');

-- --------------------------------------------------------

--
-- Estrutura da tabela `quarto`
--

CREATE TABLE `quarto` (
  `id` int(11) NOT NULL,
  `num_quarto` varchar(6) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `descricao` varchar(800) NOT NULL,
  `valor` double(10,2) NOT NULL,
  `status` int(11) NOT NULL,
  `reservado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `quarto`
--

INSERT INTO `quarto` (`id`, `num_quarto`, `tipo`, `descricao`, `valor`, `status`, `reservado`) VALUES
(1, '1', 'Duplo Casal', 'Cama de casal, Ar Condicionado,\nFrigobar,Tv 65\',Internet,Vista Pra Praia', 250.00, 1, 0),
(2, '2', 'Duplo Solteiro', 'Duas Camas Solteiro, Ar Condicionado,\nFrigobar,Tv 65\',Internet', 195.00, 1, 0),
(3, '3', 'Duplo Casal', 'Cama de casal, Ar Condicionado,\nFrigobar,Tv 65\',Internet,Vista Pra Praia', 250.00, 1, 0),
(4, '4', 'Triplo Casal', 'Cama de casal, Cama Solteiro\nAr Condicionado\nFrigobar,Tv 65\',Internet', 300.00, 1, 0),
(5, '5', 'Triplo Solteiro', 'Três Camas Solteiro, Ar Condicionado\nFrigobar,Tv 65\',Internet,Vista Pra Praia', 280.00, 1, 0),
(6, '6', 'Suíte P', 'Cama King Size, Espelho no Teto,\nHidroMassagem, TV 70\', Alexa,\nGeladeira FrossFree, Vista Para Praia', 900.00, 1, 1),
(7, '7', 'Single', 'Cama Solteiro,Frigobar,TV 45\',Banheira,\nPole Dance,Vista Para Praia', 230.00, 1, 0),
(8, '8', 'Single', 'Cama Solteiro,Frigobar,TV 45\',Banheira,\nPole Dance,Vista Para Praia', 230.00, 1, 0),
(9, '9', 'Triplo Casal', 'Cama de casal, Cama Solteiro\nAr Condicionado\nFrigobar,Tv 65\',Internet', 300.00, 1, 0),
(10, '10', 'Duplo Solteiro', 'Duas Camas Solteiro, Ar Condicionado,\nFrigobar,Tv 65\',Internet', 195.00, 1, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `reserva`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `reserva`
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
(29, '2023-05-31', '2029-12-05', '2023-05-31', 1, 6, 1, 2142000.00, 'Ta achando que eu to liso é', 'Reservada'),
(30, '2023-11-12', '2023-12-10', '2023-05-31', 1, 7, 1, 6440.00, 'uhoho', 'Cancelada');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `fpag`
--
ALTER TABLE `fpag`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `quarto`
--
ALTER TABLE `quarto`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`),
  ADD KEY `fpag_id` (`fpag_id`),
  ADD KEY `quarto_id` (`quarto_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `fpag`
--
ALTER TABLE `fpag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `quarto`
--
ALTER TABLE `quarto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`fpag_id`) REFERENCES `fpag` (`id`),
  ADD CONSTRAINT `reserva_ibfk_4` FOREIGN KEY (`quarto_id`) REFERENCES `quarto` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
