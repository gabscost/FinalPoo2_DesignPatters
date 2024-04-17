# FinalPoo2_DesignPatters

Este sistema fornece uma plataforma completa para gerenciar cursos online, facilitando a administração dos cursos, a transação de pagamentos e a autenticação de usuários. Ele pode ser usado por instituições educacionais, empresas de treinamento ou qualquer organização que deseje oferecer cursos online aos seus usuários.

![Tela Login](https://github.com/gabscost/FinalPoo2_DesignPatters/assets/104831757/031aff44-6a01-4a5b-a8ca-85b95a80d389)
![Tela Cadastro](https://github.com/gabscost/FinalPoo2_DesignPatters/assets/104831757/697fc12c-7c90-4a62-bab1-db43a4b22a01)
![Portal](https://github.com/gabscost/FinalPoo2_DesignPatters/assets/104831757/cb1464fd-1186-4576-b538-2712609d472a)

![SeletorCurso](https://github.com/gabscost/FinalPoo2_DesignPatters/assets/104831757/9a049bf4-b1d5-4b3a-bff8-3c5cb3754fac)
![FormaPagamento](https://github.com/gabscost/FinalPoo2_DesignPatters/assets/104831757/8a8b77f5-5ab0-432d-bee3-08b0031b33cd)

## Padrões de Projeto

### Factory
O padrão Factory Method é aplicado na classe `CursoFactory`. Ele define uma interface para criar um objeto, mas permite que as subclasses decidam qual classe concreta instanciar. No caso, `CursoFactory` é uma fábrica de cursos que cria instâncias de cursos concretos, como `CursoJava` e `CursoPython`, com base no tipo fornecido.

### Decorator
O padrão Decorator é implementado nas classes `CursoComConteudoExtra` e `CursoDecorator`. Ele permite adicionar comportamentos adicionais a objetos de forma dinâmica. No código, `CursoComConteudoExtra` decorador adiciona conteúdo extra aos cursos existentes, sem modificar sua estrutura interna. Ele estende a funcionalidade dos cursos básicos, como `CursoJava` e `CursoPython`.

### Singleton
O padrão Singleton é aplicado na classe `GerenciadorCursos`. Ele garante que apenas uma única instância da classe seja criada durante toda a execução do programa. Isso é útil para cenários em que é necessário ter exatamente uma instância de uma classe para coordenar ações em todo o sistema, como o gerenciamento de cursos.

### Strategy
O padrão Strategy é implementado nas interfaces `EstrategiaPagamento` e suas classes concretas `PagamentoBoleto` e `PagamentoCartao`. Ele permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. No caso, diferentes estratégias de pagamento são definidas, como pagamento via boleto bancário ou cartão de crédito, e podem ser facilmente trocadas conforme necessário.

## Princípios de Projeto

### Princípio da Responsabilidade Única (SRP)
O código segue o SRP ao atribuir responsabilidades específicas a cada classe. Por exemplo, a classe `CursoFactory` é responsável por criar instâncias de cursos, a classe `GerenciadorCursos` é responsável por gerenciar os cursos, e a classe `LoginController` é responsável por controlar o cadastro e login de usuários.

### Princípio do Aberto/Fechado (OCP)
O OCP é respeitado na estrutura do código, pois novos tipos de cursos podem ser adicionados sem a necessidade de modificar o código existente. Isso é alcançado através da interface `Curso` e das classes que a implementam, permitindo que novas implementações de cursos sejam adicionadas sem afetar o código existente.

### Princípio da Substituição de Liskov (LSP)
O LSP é aplicado através do uso de interfaces e classes concretas que as implementam. Por exemplo, a classe `CursoComConteudoExtra` pode ser tratada da mesma forma que a interface `Curso`, garantindo que objetos dessa classe possam ser substituídos por instâncias de `Curso` sem afetar o comportamento do programa.

## Conclusão

O código apresentado segue padrões de projeto e princípios sólidos de forma eficaz, o que contribui para a sua manutenção, extensibilidade e reutilização. Aqui estão algumas conclusões sobre o código e a importância de utilizar padrões e princípios de projeto:

### Padrões de Projeto
- O código utiliza o padrão Factory para criar instâncias de objetos sem expor a lógica de criação. Isso facilita a adição de novos tipos de objetos sem modificar o código existente.
- O padrão Singleton é aplicado na classe `GerenciadorCursos`, garantindo que exista apenas uma instância dessa classe em toda a execução do programa. Isso é útil quando há a necessidade de compartilhar um único recurso em diferentes partes do sistema.

### Princípios SOLID
- Os princípios SOLID são seguidos de maneira geral no código. Cada classe tem uma única responsabilidade, é aberta para extensão e fechada para modificação, e depende de abstrações em vez de implementações concretas.
- O código é organizado de forma a facilitar a manutenção e a extensão, evitando acoplamento excessivo entre as classes e permitindo que novas funcionalidades sejam adicionadas com relativa facilidade.

### Importância dos Padrões e Princípios de Projeto
- Utilizar padrões e princípios de projeto é fundamental para criar um código limpo, modular e de fácil manutenção.
- Esses padrões e princípios promovem a reutilização de código, a redução de duplicação e a melhoria na legibilidade, tornando o desenvolvimento de software mais eficiente e menos propenso a erros.
- Além disso, ao seguir padrões e princípios reconhecidos pela comunidade de desenvolvimento de software, é mais provável que outros desenvolvedores compreendam e colaborem no código, facilitando o trabalho em equipe e a evolução do projeto ao longo do tempo.

Em resumo, o uso adequado de padrões de projeto e princípios SOLID é essencial para desenvolver software de alta qualidade, que seja robusto, flexível e fácil de manter.

Desenvolvedores: Gabriel Vitor, Matheus Palmieri
