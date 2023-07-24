from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
wait = WebDriverWait(driver, 10)
driver.get("https://v1.training-support.net/selenium/tab-opener")
print("Page title is: ", driver.title)

print("Current window handle: ", driver.current_window_handle)
driver.find_element(By.ID, "launcher").click()

wait.until(expected_conditions.number_of_windows_to_be(2))
print("All window handles: ", driver.window_handles)

driver.switch_to.window(driver.window_handles[1])

print("Current window handle: ", driver.current_window_handle)
print("New Tab title: ", driver.title)
heading = driver.find_element(By.XPATH, "//div[@class='content']")
print(heading.text)

driver.find_element(By.ID, "actionButton").click()
wait.until(expected_conditions.number_of_windows_to_be(3))
print("All window handles: ", driver.window_handles)

driver.switch_to.window(driver.window_handles[2])

print("Current window handle: ", driver.current_window_handle)
print("New Tab title: ", driver.title)
heading = driver.find_element(By.XPATH, "//div[@class='content']")
print(heading.text)
driver.quit()
