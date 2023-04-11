package br.com.juliodelima.taskit.signup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes Automizatizados da Funcionalidade de Sign Up")
public class SignUpTests {
    @Test
    @DisplayName("Registrar um novo usuário com dados válidos")
    public void testRegistrarUmNovoUsuarioComDadosValidos(){
        //Vou abrir o Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        // Abrir o site do Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        //Vou clicar no botão que tem o ID igual a signup
        navegador.findElement(By.id("signup")).click();

        //Vou digitar o nome no campo com ID igual a name-sign-up
        navegador.findElement(By.id("name-sign-up")).sendKeys("Andre");

        //Vou digitar o campo com ID é igual a login-sign-up
        navegador.findElement(By.id("login-sign-up")).sendKeys("Andre0000057");

        //Vou digitar a senha no campo ID igual a password-sign-up

        navegador.findElement(By.id("password-sign-up")).sendKeys("123456");

        //Vou clicar no botão com ID igual a btn-submit-sign-up
        navegador.findElement(By.id("btn-submit-sign-up")).click();

        //Validar que o texto Hi, Andre foi apresentado no elemento que possui a class igual a me
        String saudacaoAtual = navegador.findElement(By.className("me")).getText();
        Assertions.assertEquals("Hi, Andre", saudacaoAtual );

        //Fechar o Navegador
        navegador.quit();
    }

}
