# Spring Boot: Utilizando @Value e @ConfigurationProperties

## Introdução ao pensamento

O Spring Boot oferece várias maneiras de ler valores de configuração, sendo as mais comuns o uso das anotações `@Value` e `@ConfigurationProperties`. Ambas são úteis para injetar valores de propriedades definidos em arquivos de configuração, como `application.properties`, em componentes Spring.

## @Value

### Definição

A anotação `@Value` é utilizada para injetar valores de propriedades diretamente em campos específicos de um bean. Ela é simples e útil para injetar valores individuais.

### Exemplo com @Value

No exemplo abaixo,contido no primeiro commit desse repositorio, usamos `@Value` para injetar valores de propriedades em um bean Spring.

```java
package com.devleofulco.Properties.Value.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SistemaMensagem implements CommandLineRunner {
    @Value ("remetente.nome")
    private String nome;
    @Value ("remetente.email")
    private String email;
    @Value ("remetente.telefones")
    private List<Long> telefones;

    @Override
    public void run(String... args)throws Exception{
        System.out.println("Mensagem enviada por: "+ remetente.getNome() + "\n E-mail: "+remetente.getEmail() +"\n Com telefone: "+ remetente.getTelefones());
        System.out.println("Seu cadastro foi aprovado! ");
    }
}
```

## @ConfigurationProperties

### Definição

A anotação `@ConfigurationProperties` é utilizada para mapear grupos de propriedades em um bean Spring. Isso é especialmente útil quando você precisa injetar um grande número de propriedades relacionadas.

### Exemplo com @ConfigurationProperties

No exemplo que segue,contido no segundo commit desse codigo, usamos `@ConfigurationProperties` para mapear um grupo de propriedades a um objeto Java.

```java
package com.devleofulco.Properties.Value.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "remetente")
public class Remetente {
    private String nome;
    private String email;
    private List<Long> telefones;

    // Getters e setters
}
```

### application.properties

```properties
remetente.nome=Leandresson Cleiton M Fulco
remetente.email=Teste@testando.com
remetente.telefones= 81990908080, 81980807070
```

## Importância de Entender essas Anotações

Entender `@Value` e `@ConfigurationProperties` é interessante para gerenciar configurações de maneira eficiente em aplicações Spring Boot. Escolher a anotação correta pode facilitar a manutenção e a escalabilidade do código.

## Facilidade em Utilizar essas Anotações no Spring Boot

O Spring Boot simplifica a injeção de propriedades com essas anotações. Utilizar `@Value` para propriedades simples e `@ConfigurationProperties` para propriedades complexas ou agrupadas torna a configuração da aplicação mais organizada e fácil de gerenciar, principalmente quando se pretende obter várias instancias de objetos de forma dinamica.

