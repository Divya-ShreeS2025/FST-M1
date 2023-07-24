from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
driver.get("https://training-support.net/selenium/DynamicControls")
print("Page title is: ", driver.title)
checkbox = driver.find_element(By.XPATH, "//input[@id='checkbox']")
checkbox.click();
print("Checkbox is selected: ", checkbox.is_selected())
checkbox.click()
print("Checkbox is selected: ", checkbox.is_selected())
driver.close()
