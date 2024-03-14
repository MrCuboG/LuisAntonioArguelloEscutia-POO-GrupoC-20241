class bank:
    def __init__():
        self.employee = []

    def add_employees(self, name, age, salary, account_number, type_account):
        self.employee.append(Employee(name, age, salary, account_number, type_account))

    def add_bank_acc(self, i, bank_account, type):
        self.employee[i].add_bank_acc(bank_account, type)

    def get_employee(self):
        return self.employee