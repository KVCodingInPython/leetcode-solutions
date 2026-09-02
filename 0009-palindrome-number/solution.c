bool isPalindrome(int x) {

    if (x < 0) {
        return false;
    }
    char str[20];

    sprintf(str, "%d", x);
    int len = strlen(str);

    for (int i = len - 1, j = 0; j < i; i--, j++) {
        if (str[i] != str[j]) {
            return false;
        }
    }
    return true;
}
