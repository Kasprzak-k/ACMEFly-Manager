# ACMEFly - Sistema de Gerenciamento de Carros Voadores

Este projeto foi desenvolvido como parte da disciplina de Programação Orientada a Objetos na PUCRS (Pontifícia Universidade Católica do Rio Grande do Sul), sob orientação do Prof. Marcelo H. Yamaguti.

## 📝 Descrição do Projeto

O ACMEFly é um sistema de gerenciamento para uma empresa que produz e vende carros voadores. O sistema permite:
- Cadastro e gerenciamento de carros voadores
- Cadastro e gerenciamento de clientes
- Registro de vendas de carros voadores
- Consultas diversas sobre carros, clientes e vendas

## 🚀 Funcionalidades

O sistema implementa as seguintes operações principais:
1. Cadastro de carros voadores
2. Cadastro de clientes
3. Consulta do carro mais barato
4. Consulta do cliente com maior renda
5. Registro de vendas de carros voadores
6. Consulta do cliente com mais carros voadores
7. Consulta de carros voadores específicos

## 📋 Formato dos Dados

### Entrada de Dados
Os dados são lidos do arquivo 'dadosentrada.txt' com o seguinte formato:
- Para carros voadores: `numero:placa:valor`
- Para clientes: `codigo:nome:renda`
- Para vendas: `numero_cliente:numero_carro`

### Saída de Dados
Os resultados são gravados no arquivo 'dadossaida.txt'

## 🛠️ Estrutura do Projeto

O projeto segue um design orientado a objetos com as seguintes classes principais:
- `ACMEFly`: Classe principal da aplicação
- `CarroVoador`: Representa um carro voador
- `Cliente`: Representa um cliente
- `Frota`: Gerencia o catálogo de carros voadores
- `Clientela`: Gerencia o cadastro de clientes

## 📊 Diagrama de Classes

O projeto inclui um diagrama de classes UML que representa a estrutura e relacionamentos entre as classes do sistema.

## ⚙️ Requisitos do Sistema

- Java Development Kit (JDK)
- IDE Java de sua preferência


## 👨‍💻 Autor

Desenvolvido como projeto acadêmico para a disciplina de Programação Orientada a Objetos - PUCRS 2025/1 
