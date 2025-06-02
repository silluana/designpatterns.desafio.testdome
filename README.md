# 🏪 MegaStore – Cálculo de Preços com Desconto
Este projeto demonstra a aplicação de princípios de Clean Code e padrões de projeto (Strategy) em Java, com foco no cálculo de preços com base em diferentes tipos de descontos promocionais de uma loja fictícia chamada MegaStore.

## 📋 Descrição do Desafio
A loja oferece três tipos de desconto, definidos por um enum DiscountType. O objetivo é implementar o método getDiscountedPrice, que recebe:
- Peso total do carrinho (cartWeight)
- Valor total da compra (totalPrice)
- Tipo de desconto (DiscountType)

E retorna o valor final com desconto, baseado nas seguintes regras:

| Tipo de Desconto | Condição de Peso | Desconto |
| ------ | ------ | ------ |
| Standard | Qualquer peso | 6% |
| Seasonal | Qualquer peso | 12% |
| Weight |	Peso ≤ 10 |	6% |
| Weight | Peso > 10 |	18% |

## 🛠️ Refatoração e Estrutura
A primeira versão utilizava condicionais com valores fixos diretamente na lógica de cálculo. Para melhorar a manutenibilidade e escalabilidade do código, o projeto foi refatorado com base nos seguintes princípios:
- SRP (Princípio da Responsabilidade Única): Cada classe trata de uma única regra de desconto.
- OCP (Aberto para extensão, fechado para modificação): É possível adicionar novos tipos de desconto sem alterar o código existente.
- Padrão Strategy: Cada estratégia de desconto implementa a interface DiscountStrategy.

## ✅ Benefícios da Abordagem
- Código modular e reutilizável
- Fácil adição de novos descontos
- Separação clara das responsabilidades
- Facilidade de testes unitários
- Aderência a boas práticas de programação orientada a objetos

## 🚀 Como Executar
Este é um projeto Java puro (sem frameworks externos).
