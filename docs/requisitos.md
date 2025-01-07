# Projeto de Desenvolvimento Java

diferentes tecnologias e abordagens, como JDBC, Spring, PostgreSQL, testes unitários, e padrões de design. Abaixo, você encontrará a descrição de cada projeto desenvolvido até o momento.

## Projetos

### 1. **Sistema de Gerenciamento de Plantas**

Este projeto é um sistema simples para gerenciar plantas em um banco de dados PostgreSQL. Ele oferece operações de **Read**, **Insert**, **Update** e **Delete** (CRUD).

#### Tecnologias Utilizadas:

- **Java**: Linguagem principal para o desenvolvimento do sistema.
- **JDBC**: Para a conexão e manipulação do banco de dados PostgreSQL.
- **PostgreSQL**: Banco de dados relacional.

#### Funcionalidades Implementadas:

- **Inserção de Plantas**: Permite inserir novas plantas no banco de dados.
- **Atualização de Plantas**: Permite atualizar as informações de uma planta existente.
- **Exclusão de Plantas**: Permite excluir uma planta do banco de dados.
- **Consulta de Plantas**: Permite consultar uma planta pelo seu código ou listar todas as plantas armazenadas.

#### Operações de Read:

- **`getPlantByCode(int code)`**: Retorna uma planta específica com base no código fornecido.
- **`getAllPlants()`**: Retorna uma lista de todas as plantas registradas no banco de dados.

#### Exemplo de Uso:

```java
PlantDAO plantDAO = new PlantDAO();
Plant plant = plantDAO.getPlantByCode(1);
if (plant != null) {
    System.out.println("Planta encontrada: " + plant.getDescription());
} else {
    System.out.println("Planta não encontrada.");
}
