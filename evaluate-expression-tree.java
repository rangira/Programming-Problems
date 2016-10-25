public double evaluate(TreeNode ptr)
    {
        if (ptr.left == null && ptr.right == null)
            return toDigit(ptr.data);
        else
        {
            double result = 0.0;
            double left = evaluate(ptr.left);
            double right = evaluate(ptr.right);
            char operator = ptr.data;
 
            switch (operator)
            {
            case '+' : result = left + right; break;
            case '-' : result = left - right; break;
            case '*' : result = left * right; break;
            case '/' : result = left / right; break;
            default  : result = left + right; break;
            }
            return result;
        }
    }
