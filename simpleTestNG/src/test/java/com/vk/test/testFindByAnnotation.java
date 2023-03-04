package com.vk.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class testFindByAnnotation {

	@FindBy(id="UserName") WebElement userNameTxt;
}
