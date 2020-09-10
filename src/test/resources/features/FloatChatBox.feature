@Login
Feature: Login Flip
  As a User
  I want login pages on flip web application
  So that I can access my account and do any activities on it

  @TestCaseKey=Flip-T1
  Scenario: 01 - Float chat box exist and shown on button right corner of login pages
    Given user membuka halaman utama Flip ID
    When user menekan button "Masuk" di pojok kanan atas halaman utama
    Then terdapat floating button untuk chat box