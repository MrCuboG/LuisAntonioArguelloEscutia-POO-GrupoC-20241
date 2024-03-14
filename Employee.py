class employee:
    def __init__(self, name, age, salary, account_number, type_account):
        self.name = name
        self.age = age
        self.salary = salary
        self.account = [BankAccount(account_number, type_account)]
        self.amount_acc = 0

    def set_age(self, age):
        if 18 <= age <= 65:
            self.age = age
        else:
            print("Invalid age")

    def set_salary(self, salary):
        if salary > 0:
            self.salary = salary
        else:
            print("Invalid salary")

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age

    def get_salary(self):
        return self.salary

    def get_amount_acc(self):
        return self.amount_acc

    def get_max_num_acc(self):
        return self.max_num_acc
    
    def withdraw(self, amount, i):
        if amount <= self.account[i].get_amount():
            self.account[i].set_amount(self.account[i].get_amount() - amount)
            print(f"Saldo restante: {self.account[i].get_amount()}")
        else:
            print("Saldo insuficiente")

    def deposit(self, amount, i):
        self.account[i].set_amount(self.account[i].get_amount() + amount)
        print(f"Saldo actualizado: {self.account[i].get_amount()}")

