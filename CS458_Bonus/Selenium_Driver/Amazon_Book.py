from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
import time


def search_amazon():
    driver = webdriver.Chrome(ChromeDriverManager().install())
    driver.get('https://www.amazon.com')
    driver.find_element_by_id('twotabsearchtextbox').send_keys("A friendly introduction to software testing")
    driver.find_element_by_id("nav-search-submit-text").click()
    driver.find_element_by_link_text("A Friendly Introduction to Software Testing").click()
    driver.find_element_by_partial_link_text("Paperback").click()
    driver.find_element_by_id("add-to-cart-button").click()
    driver.find_element_by_link_text("Cart").click()
    driver.find_element_by_id("a-autoid-0").click()
    driver.find_element_by_id("dropdown1_0").click()
    time.sleep(10)


if __name__ == "__main__":

    search_amazon()