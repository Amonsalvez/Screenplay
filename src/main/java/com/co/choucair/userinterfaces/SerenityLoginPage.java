package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SerenityLoginPage {


  public static final Target TXT_USER = Target.the("campo usuario")
          .located(By.id("user-name"));

  //public static final Target TXT_USER = Target.the("txt")
          //.located(By.xpath("//input[@id='user-name']"));

  public static final Target TXT_PASS = Target.the("campo contraseña")
          .located(By.id("password"));

 // public static final Target TXT_PASS = Target.the("txt")
   //       .located(By.xpath("//input[@id='password']"));

  public static final Target BTN_SUBMIT = Target.the("botón de enviar")
          .located(By.id("login-button"));

  public static final Target TXT_VALIDATION = Target.the("título Products")
          .locatedBy("//span[contains(text(),'{0}')]");





}