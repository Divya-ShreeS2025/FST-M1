from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
wait = WebDriverWait(driver, 10)
driver.get("https://v1.training-support.net/selenium/javascript-alerts")
print("Page title is: ", driver.title)

driver.find_element(By.ID, "prompt").click()
prompt_alert = driver.switch_to.alert
print(prompt_alert.text)
prompt_alert.send_keys("Python")
prompt_alert.accept()
driver.close()
