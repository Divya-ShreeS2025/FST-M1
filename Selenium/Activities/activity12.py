from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
driver.get("https://training-support.net/selenium/DynamicControls")
print("Home page title: " + driver.title);
inputTextBox = driver.find_element(By.XPATH,"//input[@id='textInput']")
print(inputTextBox.is_enabled())
driver.find_element(By.XPATH,"//button[contains(text(),'Enable Input')]").click()
print(inputTextBox.is_enabled())
driver.quit()
