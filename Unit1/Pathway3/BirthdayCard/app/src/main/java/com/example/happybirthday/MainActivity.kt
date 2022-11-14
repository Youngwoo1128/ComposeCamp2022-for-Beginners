package com.example.happybirthday

import androidx.compose.foundation.layout.Row
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

/*
* Compose 함수 만들기
*
* 1. Compose 어노테이션 추가 -> @Compose
* 2. 함수 생성
* 3. 함수 호출
*
* Text -> 기존 TextView
* Text Size는 따로 import 해줘야함
* sp 쓸꺼면 import androidx.compose.ui.unit.sp
* dp 쓸꺼면 import androidx.compose.ui.unit.dp
*
* Compose에서 레이아웃 잡기
* Row, Column, Box 3가지가 있음
* 말 그대로 Row는 가로
* Column은 세로
* Box는 람다 영역 내에서 하나하나 쌓는 구조 -> BirthdayGreetingWithImage 을 예를 들면 Image 영역 위에 Text 가 있는 구조
*
* Modifier -> Modifier 는 해당 뷰를 설정하는 interface
* 오늘 까지 한것만 봐서는 크기, 패딩 같은 영역을 정의하는 interface 로 추정
*
* */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithText(message = "Happy Birthday WooJoo!", "- from Jupiter")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithTextPreview() {
    HappyBirthdayTheme {
//        BirthdayGreetingWithText(message = "Happy Birthday WooJoo!", from = "- from Jupiter")
        BirthdayGreetingWithImage(message = stringResource(R.string.happy_birthday_text), from = "- from Jupiter")
    }
}

// 7. 텍스트 정렬 및 패딩 추가
@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    Column {
        Text(text = message, fontSize = 36.sp, modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.Start).padding(start = 16.dp, top = 16.dp))
        Text(text = from, fontSize = 24.sp, modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.End).padding(start = 16.dp, end = 16.dp))
    }
}

// 5. Box 레이아웃 추
@Composable
fun BirthdayGreetingWithImage(message: String, from: String) { 
    val image = painterResource(id = R.drawable.img_birthday)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}

