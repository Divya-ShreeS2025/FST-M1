from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
wait = WebDriverWait(driver, 10)
# Navigate to URL
driver.get("https://training-support.net/selenium/DynamicControls")
print("Page title is: ", driver.title)
checkbox = driver.find_element(By.XPATH, "//input[@id='checkbox']")
checkbox_toggle = driver.find_element(By.XPATH, "//button[contains(text(),'Toggle Checkbox')]")
print("Checkbox is visible: ", checkbox.is_displayed())
checkbox_toggle.click()
wait.until(expected_conditions.invisibility_of_element(checkbox))
print("Checkbox is visible: ", checkbox.is_displayed())
