from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
wait = WebDriverWait(driver, 10)
driver.get("https://www.v1.training-support.net/selenium/javascript-alerts")
print("Page title is: ", driver.title)

driver.find_element(By.ID, "confirm").click()
confirm_alert = driver.switch_to.alert
print(confirm_alert.text)
confirm_alert.accept()
driver.close()
