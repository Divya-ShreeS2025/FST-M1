from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
wait = WebDriverWait(driver, 10)
driver.get("https://v1.training-support.net/selenium/selects")
print("Page title is: ", driver.title)
single_select = driver.find_element(By.ID, "single-select")
dropdown = Select(single_select)

dropdown.select_by_visible_text("Option 2")
print("Selected option: ", dropdown.first_selected_option.text)

dropdown.select_by_index(3)
print("Selected option: ", dropdown.first_selected_option.text)

dropdown.select_by_value("4")
print("Selected option: ", dropdown.first_selected_option.text)

select_options = dropdown.options
for option in select_options:
    print("Option: ", option.text)
driver.close()
