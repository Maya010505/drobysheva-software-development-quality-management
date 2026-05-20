import time
import pytest
import os
from pywinauto import Application, Desktop


class TestCalculatorAutomation:
    def setup_method(self):
        os.system("taskkill /f /im CalculatorApp.exe >nul 2>&1")
        os.system("taskkill /f /im calc.exe >nul 2>&1")
        time.sleep(0.5)

        Application(backend="uia").start("calc.exe")

        self.desktop = Desktop(backend="uia")
        self.dlg = self.desktop.window(title_re=".*Калькулятор.*")
        self.dlg.wait("exists", timeout=10)

        self.dlg.set_focus()
        self.dlg.type_keys('%1')
        time.sleep(0.5)

    def teardown_method(self):
        self.dlg.close()

    def get_result_text(self):
        element = self.dlg.child_window(auto_id="CalculatorResults", control_type="Text")
        return element.window_text()

    def test_addition(self):
        """Тест сложения: 2 + 3 = 5"""
        self.dlg.child_window(auto_id="num2Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="plusButton", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num3Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="equalButton", control_type="Button").invoke()
        assert "5" in self.get_result_text()

    def test_subtraction_negative(self):
        """Тест вычитания с отрицательным результатом: 5 - 10 = -5"""
        self.dlg.child_window(auto_id="num5Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="minusButton", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num1Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num0Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="equalButton", control_type="Button").invoke()
        res = self.get_result_text()
        assert "-" in res or "минус" in res
        assert "5" in res

    def test_multiplication(self):
        """Тест умножения: 9 * 6 = 54"""
        self.dlg.child_window(auto_id="num9Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="multiplyButton", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num6Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="equalButton", control_type="Button").invoke()
        assert "54" in self.get_result_text()

    def test_division(self):
        """Тест деления: 15 / 3 = 5"""
        self.dlg.child_window(auto_id="num1Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num5Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="divideButton", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num3Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="equalButton", control_type="Button").invoke()
        assert "5" in self.get_result_text()

    def test_square_root(self):
        """Тест извлечения квадратного корня: √81 = 9"""
        self.dlg.child_window(auto_id="num8Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num1Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="squareRootButton", control_type="Button").invoke()
        assert "9" in self.get_result_text()

    def test_percent(self):
        """Тест вычисления процентов: 200 * 5% = 10"""
        self.dlg.child_window(auto_id="num2Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num0Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num0Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="multiplyButton", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num5Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="percentButton", control_type="Button").invoke()
        self.dlg.child_window(auto_id="equalButton", control_type="Button").invoke()
        assert "10" in self.get_result_text()

    def test_decimal_point(self):
        """Тест работы с десятичными дробями: 0.5 * 4 = 2"""
        self.dlg.child_window(auto_id="num0Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="decimalSeparatorButton", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num5Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="multiplyButton", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num4Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="equalButton", control_type="Button").invoke()
        assert "2" in self.get_result_text()

    def test_clear_all(self):
        """Тест кнопки очистки (C)"""
        self.dlg.child_window(auto_id="num7Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="clearButton", control_type="Button").invoke()
        assert "0" in self.get_result_text()

    def test_backspace(self):
        """Тест удаления последнего символа (Backspace)"""
        self.dlg.child_window(auto_id="num1Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num2Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="backSpaceButton", control_type="Button").invoke()
        assert "1" in self.get_result_text()

    def test_division_by_zero(self):
        """Тест обработки ошибки: деление на ноль"""
        self.dlg.child_window(auto_id="num8Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="divideButton", control_type="Button").invoke()
        self.dlg.child_window(auto_id="num0Button", control_type="Button").invoke()
        self.dlg.child_window(auto_id="equalButton", control_type="Button").invoke()
        res = self.get_result_text()
        assert "невозможно" in res
