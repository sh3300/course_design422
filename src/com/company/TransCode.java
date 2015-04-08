package com.company;

        import java.io.FileReader;
        import java.io.FileWriter;
        import java.io.IOException;

/**
 * Created by Tiny on 2015/4/7.
 */
public class TransCode {

//cpp关键词

    String[] Cpp_Datatypes = new String[]{"ATOM", "BOOL", "BOOLEAN", "BYTE", "CHAR", "COLORREF", "DWORD", "DWORDLONG"
            , "DWORD_PTR", "DWORD32", "DWORD64", "FLOAT", "HACCEL", "HALF_PTR", "HANDLE", "HBITMAP", "HBRUSH"
            , "HCOLORSPACE", "HCONV", "HCONVLIST", "HCURSOR", "HDC", "HDDEDATA", "HDESK", "HDROP", "HDWP"
            , "HENHMETAFILE", "HFILE", "HFONT", "HGDIOBJ", "HGLOBAL", "HHOOK", "HICON", "HINSTANCE"
            , "HKEY", "HKL", "HLOCAL", "HMENU", "HMETAFILE", "HMODULE", "HMONITOR", "HPALETTE", "HPEN"
            , "HRESULT", "HRGN", "HRSRC", "HSZ", "HWINSTA", "HWND", "INT", "INT_PTR", "INT32", "INT64"
            , "LANGID", "LCID", "LCTYPE", "LGRPID", "LONG", "LONGLONG", "LONG_PTR", "LONG32", "LONG64"
            , "LPARAM", "LPBOOL", "LPBYTE", "LPCOLORREF", "LPCSTR", "LPCTSTR", "LPCVOID", "LPCWSTR"
            , "LPDWORD", "LPHANDLE", "LPINT", "LPLONG", "LPSTR", "LPTSTR", "LPVOID", "LPWORD", "LPWSTR"
            , "LRESULT", "PBOOL", "PBOOLEAN", "PBYTE", "PCHAR", "PCSTR", "PCTSTR", "PCWSTR", "PDWORDLONG"
            , "PDWORD_PTR", "PDWORD32", "PDWORD64", "PFLOAT", "PHALF_PTR", "PHANDLE", "PHKEY", "PINT", "PINT_PTR"
            , "PINT32", "PINT64", "PLCID", "PLONG", "PLONGLONG", "PLONG_PTR", "PLONG32", "PLONG64", "POINTER_32"
            , "POINTER_64", "PSHORT", "PSIZE_T", "PSSIZE_T", "PSTR", "PTBYTE", "PTCHAR", "PTSTR", "PUCHAR"
            , "PUHALF_PTR", "PUINT", "PUINT_PTR", "PUINT32", "PUINT64", "PULONG", "PULONGLONG", "PULONG_PTR"
            , "PULONG32", "PULONG64", "PUSHORT", "PVOID", "PWCHAR", "PWORD", "PWSTR", "SC_HANDLE", "SC_LOCK"
            , "SERVICE_STATUS_HANDLE", "SHORT", "SIZE_T", "SSIZE_T", "TBYTE", "TCHAR", "UCHAR", "UHALF_PTR"
            , "UINT", "UINT_PTR", "UINT32", "UINT64", "ULONG", "ULONGLONG", "ULONG_PTR", "ULONG32", "ULONG64"
            , "USHORT", "USN", "VOID", "WCHAR", "WORD", "WPARAM", "WPARAM", "WPARAM", "char", "bool", "short", "int"
            , "__int32", "__int64", "__int8", "__int16", "long", "float", "double", "__wchar_t", "clock_t"
            , "_complex", "_dev_t", "_diskfree_t", "div_t", "ldiv_t", "_exception", "_EXCEPTION_POINTERS"
            , "FILE", "_finddata_t", "_finddatai64_t", "_wfinddata_t", "_wfinddatai64_t", "__finddata64_t"
            , "__wfinddata64_t", "_FPIEEE_RECORD", "fpos_t", "_HEAPINFO", "_HFILE", "lconv", "intptr_t"
            , "jmp_buf", "mbstate_t", "_off_t", "_onexit_t", "_PNH", "ptrdiff_t", "_purecall_handler"
            , "sig_atomic_t", "size_t", "_stat", "__stat64", "_stati64", "terminate_function", "time_t"
            , "__time64_t", "_timeb", "__timeb64", "tm", "uintptr_t", "_utimbuf", "va_list", "wchar_t"
            , "wctrans_t", "wctype_t", "wint_t", "signed"};
    String[] Cpp_Keywords = new String[]{"break", "case", "catch", "class", "const", "__finally", "__exception"
            , "__try", "const_cast", "continue", "private", "public", "protected", "__declspec", "default"
            , "delete", "deprecated", "dllexport", "dllimport", "do", "dynamic_cast", "else", "enum", "explicit"
            , "extern", "if", "for", "friend", "goto", "inline", "mutable", "naked", "namespace", "new", "noinline"
            , "noreturn", "nothrow", "register", "reinterpret_cast", "return", "selectany", "sizeof", "static"
            , "static_cast", "struct", "switch", "template", "this", "thread", "throw", "true", "false", "try"
            , "typedef", "typeid", "typename", "union", "using", "uuid", "virtual", "void", "volatile", "whcar_t"
            , "while"};
    String[] Cpp_Functions = new String[]{"assert", "isalnum", "isalpha", "iscntrl", "isdigit", "isgraph"
            , "islower", "isprint", "ispunct", "isspace", "isupper", "isxdigit", "tolower", "toupper", "errno"
            , "localeconv", "setlocale", "acos", "asin", "atan", "atan2", "ceil", "cos", "cosh", "exp", "fabs"
            , "floor", "fmod", "frexp", "ldexp", "log", "log10", "modf", "pow", "sin", "sinh", "sqrt", "tan"
            , "tanh", "jmp_buf", "longjmp", "setjmp", "raise", "signal", "sig_atomic_t", "va_arg", "va_end"
            , "va_start", "clearerr", "fclose", "feof", "ferror", "fflush", "fgetc", "fgetpos", "fgets"
            , "fopen", "fprintf", "fputc", "fputs", "fread", "freopen", "fscanf", "fseek", "fsetpos", "ftell"
            , "fwrite", "getc", "getchar", "gets", "perror", "printf", "putc", "putchar", "puts", "remove"
            , "rename", "rewind", "scanf", "setbuf", "setvbuf", "sprintf", "sscanf", "tmpfile", "tmpnam"
            , "ungetc", "vfprintf", "vprintf", "vsprintf", "abort", "abs", "atexit", "atof", "atoi", "atol"
            , "bsearch", "calloc", "div", "exit", "free", "getenv", "labs", "ldiv", "malloc", "mblen", "mbstowcs"
            , "mbtowc", "qsort", "rand", "realloc", "srand", "strtod", "strtol", "strtoul", "system", "wcstombs"
            , "wctomb", "memchr", "memcmp", "memcpy", "memmove", "memset", "strcat", "strchr", "strcmp", "strcoll"
            , "strcpy", "strcspn", "strerror", "strlen", "strncat", "strncmp", "strncpy", "strpbrk", "strrchr"
            , "strspn", "strstr", "strtok", "strxfrm", "asctime", "clock", "ctime", "difftime", "gmtime"
            , "localtime", "mktime", "strftime", "time"};

    //网页代码开头
String HeadCode = new String("<html>\r\n" +
            "<head>\r\n" +
            "<style type=\"text/css\">\r\n" +
            "span#number {background-color:#ffffff;width:50px;float:left;}\r\n" +
            "span#code   {background-color:#ffffff;float:center;}\r\n" +
            "p\r\n" +
            "{border-style: solid;border-color: #FFFFFF green #FFFFFF #FFFFFF;\r\n" +
            "border-width: 0px 8px 0px 0px;\r\n" +
            "margin : 0px 0px 0px 0px;\r\n" +
            "line-height:17px;\r\n" +
            "font-size:1em;\r\n" +
            "text-align: right;\r\n" +
            "padding-right: 0.2cm;\r\n" +
            "}\r\n" +
            "p2\r\n" +
            "{\r\n" +
            "border-style: none;\r\n" +
            "border-color: #FFFFFF #FFFFFF #FFFFFF #FFFFFF;\r\n" +
            "background-color: gray;\r\n" +
            "line-height:17px;\r\n" +
            "font-size:1.2em;\r\n" +
            "}\r\n" +
            "\r\n" +
            "a{color: #0000FF;font-weight:bold;}\r\n" +
            "b{color: #3300FF;font-weight:bold;}\r\n" +
            "c{color: #336600;font-weight:bold;}\r\n" +
            "d{color: #C0C0C0;}\r\n" +
            "e{color: #FF00CC;}\r\n" +
            "f{color: #006600;font-weight:bold;}\r\n" +
            "\r\n" +
            "</style>\r\n" +
            "</head>\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n" +
            "<body>\r\n" +
            "\r\n" +
            "<span id=\"number\">\r\n" +
            "<p>");
//网页代码中间
    String MidCode = new String("</p>\r\n" +
        "</span>\r\n" +
        "\r\n" +
        "<span id=\"code\">\r\n" +
        "<p2><pre>");

    //网页代码末尾
    String FloorCode = new String("</pre>\r\n" +
            "</p2>\r\n" +
            "</span>\r\n" +
            "</body>\r\n" +
            "</html>");


    public int Java_Find(String s)                       //根据单词匹配java的关键词
    {
        return 0;
    }

    public int Cpp_Find(String s)                       //根据单词匹配c语言的关键词
    {
        int i , a ,b , c ;

        a = Cpp_Datatypes.length;
        b = Cpp_Keywords.length;
        c = Cpp_Functions.length;

        i = 0;
        while(i<a)
        {
            if(Cpp_Functions[i].equals(s)==false) i++;   //如果匹配不成功就继续寻找
            else return 1;                              //如果匹配成功返回1（第一种关键词）
        }
        i = 0;
        while(i<b)
        {
            if(Cpp_Keywords[i].equals(s)==false) i++;
            else return 2;
        }
        i = 0;
        while(i<c)
        {
            if(Cpp_Functions[i].equals(s)==false) i++;
            else return 3;
        }
        return 0; //说明没找到
    }

    public void AddHeadCode(int n) throws IOException                            //增加头部html代码
    {
        Integer i;
        String str = new String();
        new FileWrite(HeadCode);

        for(i = 1 ; i <= n ; i++)
        {
            str = i.toString();
            new FileWrite(str+"<br>");
        }
    }

    public void AddMidCode() throws IOException
    {
        new FileWrite(MidCode);
    }

    public void AddFloorCode() throws IOException                          //增加尾部html代码
    {
        new FileWrite(FloorCode);
    }

    public int IsChar(char ch)   //判断是不是字符
    {
        if( 'a' <= ch && ch <= 'z' )        return 1;  //说明是字符
        if( 'A' <= ch && ch <= 'Z' )          return 1;  //说明是字符
        if( ch ==  '_' )                      return 1;  //说明是字符

        return 0;  //说明不是字符
    }

    public int IsNumber(char ch) //判断是不是数字
    {
        if('0' <= ch && ch <= '9')
        return 1;   //说明是数字
        return 0;   //说明不是数字
    }

    public int IsSpace(char ch)  //判断是不是空格
    {
        if( ch == ' ')
            return 1;   //说明是空格
        return 0;       //说明不是空格
    }

    public void Pick(String s) throws IOException {
        int i = 0, k = 0, j = 0;
        int n = 0;
        int x = 0;  //x=1表示已经有一个斜杠
                    //x=2表示处于单行注释状态
                    //x=3表示处于段落注释状态
                    //x=4表示处于单引号状态
                    //x=5表示处于双引号状态
        char[] str = new char[30000];
        while( i < s.length())
        {
            if( x == 2 )       //如果处于单行注释状态下
            {
                k = i;j = 0;
                while(s.charAt(k+j)!='\n')            //储存该行字符串
                {
                    str[j] = s.charAt(j+k);
                    j++;
                }
                str[j] = s.charAt(j+k); j++;            //读入最后一个换行符
                String ss = String.valueOf(str);
                TransColor(4, ss);
                i = i+j;
                x = 0;      //取消注释状态
            }
            else
            if( x == 3 )        //处于段落注释状态
            {
                k = i;j = 0;
                while( s.charAt(k+j) != '*' && s.charAt(k+j+1) != '/')
                {
                    str[j] = s.charAt(j+k);
                    j++;
                }
                str[j] = s.charAt(j+k); j++;   //读入最后两个字符
                str[j] = s.charAt(j+k); j++;
                String ss = String.valueOf(str);
                TransColor(4, ss);
                i = i+j;
                x = 0;  //取消注释状态
            }
            else
            if( x == 4 )        //处于单引号状态
            {
                k = i;j = 1;
                str[0] = '\'';
                while( s.charAt(k+j) != '"')
                {
                    str[j] = s.charAt(j+k);
                    j++;
                }
                str[j] = s.charAt(j+k); j++;   //读入最后一个字符
                str[j] = s.charAt(j+k); j++;
                String ss = String.valueOf(str);
                TransColor(4, ss);
                i = i+j;
                x = 0;  //取消字符串状态
            }
            if( x == 5 )        //处于双引号状态
            {
                k = i;j = 1;
                str[0] = '\"';
                while( s.charAt(k+j) != '\'')
                {
                    str[j] = s.charAt(j+k);
                    j++;
                }
                str[j] = s.charAt(j+k); j++;   //读入最后一个字符
                str[j] = s.charAt(j+k); j++;
                String ss = String.valueOf(str);
                TransColor(6, ss);
                i = i+j;
                x = 0;  //取消字符串状态
            }
            else                //都不属于
            {
                if (IsChar(s.charAt(i)) == 1)
                {
                    //储存纯字母的字符串
                    k = i;
                    j = 0;
                    while((k+j)<s.length()&&(IsChar(s.charAt(j+k)) == 1)) //储存一串完整的字符
                    {
                        System.out.print(s.charAt(j+k));System.out.println(j);
                        str[j] = s.charAt(j + k);
                        j++;
                    }System.out.println(j);
                    //如果下一位是空格，就把该字符串存起来
                    if (IsSpace(s.charAt(j+k)) == 1)
                        str[j] = '\0';
                    //判断是不是关键词
                    String ss = String.valueOf(str);
                    System.out.println(ss);
                    n = Cpp_Find(ss);
                    if (n == 1) {
                        TransColor(1, ss);
                        i = i + j;
                    }
                    if (n == 2) {
                        TransColor(2, ss);
                        i = i + j;
                    }
                    if (n == 3) {
                        TransColor(3, ss);
                        i = i + j;
                    }
                    if (n == 0) new FileWrite(ss);

                }
                else
                {
                    if (x == 1)
                        if (s.charAt(i) == '/') { x = 2; i = i-2;}    //说明后面是行注释
                        else
                          if (s.charAt(i) == '*') { x = 3; i = i-2;}    //说明后面是段落注释
                          else x = 0;
                    else
                    {
                        if(s.charAt(i) == '\"') { x = 4 ; i = i-1;} //说明后面是字符串
                        else
                        if(s.charAt(i) == '\'') { x = 5 ; i = i-1;} //说明后面是字符串
                        else    //说明后面不是字符串也不是注释也不是字母
                        {
                            new FileWrite(s.charAt(i));
                            i++;
                        }
                    }
                }
            }

        }

    }

    /*
    0.普通代码   -->   #000000   black
    1.Datatypes  -->  #0000FF   blue    a
    2.Keywords   -->  #3300FF           b
    3.Functions  -->  #336600           c
    4.注释       -->  #C0C0C0           d
    5.常量       -->  #FF00CC          e
    6.字符串     -->  #006600          f

 */
    public void TransColor(int x,String s) throws IOException {
        if( x == 1){
            new FileWrite("<a>");
            new FileWrite(s);
            new FileWrite("</a>");
        }
        if( x == 2){
            new FileWrite("<b>");
            new FileWrite(s);
            new FileWrite("</b>");
        }
        if( x == 3){
            new FileWrite("<c>");
            new FileWrite(s);
            new FileWrite("</c>");
        }
        if( x == 4){
            new FileWrite("<d>");
            new FileWrite(s);
            new FileWrite("</d>");
        }
        if( x == 5){
            new FileWrite("<e>");
            new FileWrite(s);
            new FileWrite("</e>");
        }
        if( x == 6){
            new FileWrite("<f>");
            new FileWrite(s);
            new FileWrite("</f>");
        }
    }

    public void TransCode() throws IOException
    {
        String ss = new String("int");

        LoadFile fl = new LoadFile("./123.txt");
        System.out.println(fl.Data);
        AddHeadCode(fl.count);

        AddMidCode();
        Pick(ss);
        AddFloorCode();
    }
}
