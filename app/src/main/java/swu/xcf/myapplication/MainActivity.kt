package swu.xcf.myapplication

import android.animation.Animator
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent as Intent

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
            Activity用来管理界面的生命周期和交互
            具体的界面需要自己来配置 res -> layout -> .xml
            通过setContextentView来关联layout布局文件和Java/kotlin代码
            所有的资源文件都会有一个ID和他的对应要访问的这些资源
         R.layout.1.jpg
         R.drawable.1.jpg
         */
        setContentView(R.layout.activity_main)

        //监听按钮点击事件
        //mloginBtn.setOnClickListener(this)
        /*
        //匿名对象
        mloginBtn.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                println("2.按钮被点击了！！！")
            }

        })
        */
        /*
        //lamda表达式
        mloginBtn.setOnClickListener({view:View?->
            println("3.按钮被点击了！！！")
        })
        mloginBtn.setOnClickListener{view:View?->
            println("4.按钮被点击了！！！")
        }

         */
        mloginBtn.setOnClickListener{

            //apply also with run
           /*
            //also
            ObjectAnimator.ofFloat(mHeader,"rotation",0f,360f).also {
                it.duration=200
                it.repeatCount=6
                it.start()

                it.addListener(object :Animator.AnimatorListener{
                    override fun onAnimationRepeat(p0: Animator?) {

                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        startActivity(Intent(this@MainActivity,DetailActivity::class.java))
                    }

                    override fun onAnimationCancel(p0: Animator?) {

                    }

                    override fun onAnimationStart(p0: Animator?) {

                    }

                })
            }
            */

            //apply
            ObjectAnimator.ofFloat(mHeader,"rotation",0f,360f).apply {
                duration=200
                repeatCount=6
                start()
                addListener(object : MyAnimatorListener() {
                    override fun onAnimationEnd(p0: Animator?) {
                        startActivity(Intent(this@MainActivity,DetailActivity::class.java))
                    }
                })
            }


            /*
            //添加旋转动画  动画结束后再跳转到下一个界面
            //旋转 平移 缩放 透明度
            val anim=ObjectAnimator.ofFloat(mHeader,"rotation",0f,360f)
            anim.duration=100
            anim.repeatCount=6
            anim.start()

            //监听动画的结束事件
            anim.addListener(object :Animator.AnimatorListener{
                override fun onAnimationRepeat(p0: Animator?) {

                }

                override fun onAnimationEnd(p0: Animator?) {
                    //界面跳转
                    startActivity(Intent(this@MainActivity,DetailActivity::class.java))
                }

                override fun onAnimationCancel(p0: Animator?) {

                }

                override fun onAnimationStart(p0: Animator?) {

                }

            })

            //界面跳转
            //startActivity(Intent(this,DetailActivity::class.java))
            */
        }



    }

    override fun onClick(p0: View?) {
        println("1.按钮被点击了！！！")
    }
}