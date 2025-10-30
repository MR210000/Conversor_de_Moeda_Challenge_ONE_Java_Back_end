                                                💱 Conversor de Moedas em Tempo Real – Java
                                                
        📑 Índice
        
        🚀 Funcionalidades
        
        🧰 Tecnologias e Bibliotecas Utilizadas
        
        📦 Estrutura do Projeto
        
        📋 Exemplo de Uso
        
        🗃️ Histórico de Conversões
        
        🧪 Testes
        
        📚 Aprendizados
        
        📌 Observações
        
        🧭 Versões do Projeto


🚀 Funcionalidades:

      Consulta de taxas de câmbio em tempo real via API
      Conversão entre as seguintes moedas:
      ARS – Peso argentino
      BOB – Boliviano boliviano
      BRL – Real brasileiro
      CLP – Peso chileno
      COP – Peso colombiano
      USD – Dólar americano
      
      Interface textual via console com menu interativo
      Histórico de conversões salvo em arquivo .txt
      Estrutura modular com métodos específicos para cada etapa
      Testes manuais para validação de fluxos e tratamento de erros

🧰 Tecnologias e Bibliotecas Utilizadas:

      Tecnologia	  Finalidade
      Java 11+	    Linguagem principal
      HttpClient	  Requisições HTTP para a API de câmbio
      HttpRequest	  Configuração das chamadas GET
      HttpResponse	Manipulação da resposta HTTP
      Gson	        Análise e conversão de dados JSON
      Scanner	      Captura de entrada do usuário via console
      FileWriter	  Registro de histórico de conversões em arquivo

📦 Estrutura do Projeto:

        Code
        /.idea
        /out
        /src
          └── Main.java
              └── CorrencyConverterPro
          └── .gitignore
          └── Conversor_de_Moeda_Challenge_ONE_Java_Back_end.ml 
        /gson-2.13.2.jar
        /historico_conversoes.txt


📋 Exemplo de Uso:

        === CONVERSOR DE MOEDAS ===
        Moedas disponíveis: USD, BRL, ARS, BOB, CLP, COP
        1. Converter moeda
        0. Sair
        Escolha uma opção: 1
        Digite a moeda de origem (ex: USD): USD
        Digite a moeda de destino (ex: BRL): BRL
        Digite o valor a converter: 100
        Resultado: 100.00 USD = 550.00 BRL

🗃️ Histórico de Conversões:

        Cada conversão realizada é registrada em um arquivo conversoes.txt, contendo:
        Data e hora da conversão
        Moeda de origem e destino
        Valor convertido
        
        Ex:
        2025-10-29 15:30:13 | 1,00 USD -> 1470,83 ARS
        2025-10-29 15:39:19 | 1,00 USD -> 5,38 BRL
        2025-10-29 15:39:42 | 1,00 BRL -> 273,60 ARS
        2025-10-29 15:40:02 | 1,00 BOB -> 556,23 COP
        2025-10-29 15:40:14 | 1,00 CLP -> 1,56 ARS
        2025-10-29 16:09:45 | 1,00 USD -> 5,38 BRL
        2025-10-29 16:11:26 | 1,00 BOB -> 135,54 CLP
        2025-10-29 16:12:56 | 1,00 BRL -> 273,60 ARS
        2025-10-29 16:15:16 | 1,00 COP -> 0,38 ARS
        2025-10-29 16:26:31 | 100,00 USD -> 693,69 BOB
        2025-10-30 09:49:59 | 1,00 USD -> 5,35 BRL
        2025-10-30 09:50:31 | 1,00 USD -> 1451,50 ARS
        2025-10-30 09:50:56 | 1,00 CLP -> 4,14 COP

🧪 Testes
    O programa foi testado manualmente com diferentes combinações de moedas e valores para garantir:
    
        Validação de entrada do usuário
        Resposta correta da API
        Cálculo preciso das taxas
        Registro adequado no histórico

📚 Aprendizados:
    
        Este projeto é ideal para quem deseja:
        Aprender a consumir APIs REST com Java
        Trabalhar com JSON usando Gson
        Criar interfaces simples via console
        Modularizar código com boas práticas
        Persistir dados em arquivos locais

📌 Observações:
    
        É necessário acesso à internet para consultar as taxas de câmbio.
        A chave da API pode ser obtida gratuitamente no site ExchangeRate-API.
        O programa pode ser expandido para incluir mais moedas ou interface gráfica futuramente.

🧭 Versões do Projeto:
    
        Este repositório contém duas versões distintas do conversor de moedas, 
        ambas com a mesma base de funcionamento, mas com interfaces de saída diferentes para fins de estudo e comparação.

🔹 Versão 1.0 – Conversão 1 para 1
    
        O usuário escolhe:
        Uma moeda de origem
        Uma moeda de destino
        Um valor a ser convertido
        O programa exibe o resultado da conversão entre essas duas moedas.

📌 Exemplo de saída:
    
        Digite a moeda de origem (ex: USD): USD
        Digite a moeda de destino (ex: BRL): BRL
        Digite o valor a converter: 100
        Resultado: 100.00 USD = 550.00 BRL

🔸 Versão 2.0 – Conversão 1 para N

        O usuário escolhe:
        Uma moeda de origem
        Um valor a ser convertido
        O programa exibe o resultado da conversão para todas as outras 5 moedas definidas no projeto.

📌 Exemplo de saída:

        Digite a moeda de origem (ex: USD): USD
        Digite o valor a converter: 100
        
        Resultado:
        100.00 USD = 550.00 BRL
        100.00 USD = 9200.00 ARS
        100.00 USD = 690.00 BOB
        100.00 USD = 89000.00 CLP
        100.00 USD = 420000.00 COP
