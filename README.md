# AllDialogDemo
自定义的万能对话框库

## 用法
```java
    val btnTop = findViewById<Button>(R.id.btn_open_top)
            btnTop.setOnClickListener(View.OnClickListener {
                val dialog = AlertDialog.Builder(this)
                        .setContentView(R.layout.dialog)
                        .setText(R.id.tv_title, "哈哈")
                        .setOnClickListener(R.id.btn_start, View.OnClickListener {
                            Toast.makeText(this, "点击", Toast.LENGTH_LONG).show()
                        })
                        .fromBottom(true)
                        .fullWidth()
                        .show()

            })
```

## 效果

![](https://ws3.sinaimg.cn/large/006tNc79gy1fpg9jwp9xoj30tq16cdj0.jpg)