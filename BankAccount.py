class bankAccount:
    def get_bank_acc(self, i):
        return self.account[i]

    def set_acc_num(self, i, acc_num):
        self.account[i].set_account_number(acc_num)

    def set_acc_type(self, i, t_acc):
        self.account[i].set_type_account(t_acc)

    def set_account(self, i, account_number):
        self.account[i].set_account_number(account_number)

    def set_type_account(self, i, type):
        self.account[i].set_type_account(type)

    def add_bank_acc(self, acc_number, typ):
        self.account.append(BankAccount(acc_number, typ))

    def get_account(self):
        return self.account