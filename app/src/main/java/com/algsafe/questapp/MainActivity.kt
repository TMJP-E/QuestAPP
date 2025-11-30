package com.algsafe.questapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.algsafe.questapp.ui.theme.QuestAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestAPPTheme {
                val navController = rememberNavController()
                val dataArray = Array(3) { IntArray(7) }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(paddingValues = innerPadding),
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = Routes.Greeting.name
                        ) {
                            composable(route = Routes.Greeting.name) {
                                GreetingScreen(onClick = { navController.navigate(Routes.Instruction.name) })
                            }
                            composable(route = Routes.Instruction.name) {
                                InstructionScreen(onClick = { navController.navigate(Routes.Question.name) })
                            }
                            composable(route = Routes.Question.name) {
                                QuestionScreen(
                                    dataArray = dataArray,
                                    onClick = { navController.navigate(Routes.Conclusion.name) }
                                )
                            }
                            composable(route = Routes.Conclusion.name) {
                                ConclusionScreen(onClick = { navController.navigate(Routes.Result.name) })
                            }
                            composable(route = Routes.Result.name) {
                                ResultScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingScreen(onClick: () -> Unit) {
    IntroBackground {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(space = 32.dp),
        ) {
            QuestAPPLogo()
            Text(
                text = stringResource(id = R.string.greeting),
                fontFamily = prozaFamily,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
            StartButton(
                text = stringResource(id = R.string.start),
                onClick = onClick,
            )
        }
    }
}

@Composable
fun InstructionScreen(onClick: () -> Unit) {
    IntroBackground {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(space = 24.dp),
        ) {
            SimpleTitle(text = stringResource(id = R.string.instructions))
            ContentText(text = stringResource(id = R.string.introduction))
            Row(
                horizontalArrangement = Arrangement.spacedBy(48.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                ProgressButton(
                    text = stringResource(id = R.string.previous),
                    enabled = false,
                    onClick = {/* Navigate forwards only */ },
                    modifier = Modifier.weight(weight = 1f)
                )
                ProgressButton(
                    text = stringResource(id = R.string.next),
                    onClick = onClick,
                    modifier = Modifier.weight(weight = 1f)
                )
            }
        }
    }
}

@Composable
fun QuestionScreen(
    dataArray: Array<IntArray>,
    onClick: () -> Unit,
) {
    val sectionArray = arrayOf(
        stringResource(id = R.string.section1),
        stringResource(id = R.string.section2),
        stringResource(id = R.string.section3),
    )
    val questionArray = Array(3) {
        Array(7) { "" }
    }
    questionArray[0][0] = stringResource(id = R.string.s1q1)
    questionArray[0][1] = stringResource(id = R.string.s1q2)
    questionArray[0][2] = stringResource(id = R.string.s1q3)
    questionArray[0][3] = stringResource(id = R.string.s1q4)
    questionArray[0][4] = stringResource(id = R.string.s1q5)
    questionArray[0][5] = stringResource(id = R.string.s1q6)
    questionArray[0][6] = stringResource(id = R.string.s1q7)

    questionArray[1][0] = stringResource(id = R.string.s2q1)
    questionArray[1][1] = stringResource(id = R.string.s2q2)
    questionArray[1][2] = stringResource(id = R.string.s2q3)
    questionArray[1][3] = stringResource(id = R.string.s2q4)
    questionArray[1][4] = stringResource(id = R.string.s2q5)
    questionArray[1][5] = stringResource(id = R.string.s2q6)
    questionArray[1][6] = stringResource(id = R.string.s2q7)

    questionArray[2][0] = stringResource(id = R.string.s3q1)
    questionArray[2][1] = stringResource(id = R.string.s3q2)
    questionArray[2][2] = stringResource(id = R.string.s3q3)
    questionArray[2][3] = stringResource(id = R.string.s3q4)
    questionArray[2][4] = stringResource(id = R.string.s3q5)
    questionArray[2][5] = stringResource(id = R.string.s3q6)
    questionArray[2][6] = stringResource(id = R.string.s3q7)

    var sectionIndex by rememberSaveable { mutableIntStateOf(0) }
    var questionIndex by rememberSaveable { mutableIntStateOf(0) }
    var selected by rememberSaveable { mutableIntStateOf(0) }

    val questionIndexMod = questionIndex % 7

    QuestionBackground {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SectionTitle(text = sectionArray[sectionIndex])
            Box(modifier = Modifier.height(240.dp)
            , contentAlignment = Alignment.Center) {
                QuestionDialog(text = questionArray[sectionIndex][questionIndexMod])
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LikertSelector(
                    level = 1, selected = selected == 1, onClick = {
                        selected = 1
                        dataArray[sectionIndex][questionIndexMod] = 1
                    })
                LikertSelector(
                    level = 2, selected = selected == 2, onClick = {
                        selected = 2
                        dataArray[sectionIndex][questionIndexMod] = 2
                    })
                LikertSelector(
                    level = 3, selected = selected == 3, onClick = {
                        selected = 3
                        dataArray[sectionIndex][questionIndexMod] = 3
                    })
                LikertSelector(
                    level = 4, selected = selected == 4, onClick = {
                        selected = 4
                        dataArray[sectionIndex][questionIndexMod] = 4
                    })
                LikertSelector(
                    level = 5, selected = selected == 5, onClick = {
                        selected = 5
                        dataArray[sectionIndex][questionIndexMod] = 5
                    })
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(48.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                ProgressButton(
                    enabled = questionIndex > 0,
                    text = stringResource(id = R.string.previous),
                    onClick = {
                        sectionIndex = (questionIndex - 1) / 7
                        questionIndex -= 1
                        selected = dataArray[sectionIndex][questionIndex % 7]
                    },
                    modifier = Modifier.weight(weight = 1f)
                )
                ProgressButton(
                    enabled = selected > 0,
                    text = stringResource(id = R.string.next),
                    onClick = if (questionIndex + 1 < 21) {
                        {
                            sectionIndex = (questionIndex + 1) / 7
                            questionIndex += 1
                            selected = if (dataArray[sectionIndex][questionIndex % 7] != 0) {
                                dataArray[sectionIndex][questionIndex % 7]
                            } else {
                                0
                            }
                        }
                    } else {
                        onClick
                    },
                    modifier = Modifier.weight(weight = 1f)
                )
            }
        }
    }
}

@Composable
fun ConclusionScreen(onClick: () -> Unit) {
}

@Composable
fun ResultScreen() {
}

@Preview(showBackground = true)
@Composable
fun DynamicPreview() {
    QuestAPPTheme {
        val dataArray = Array(3) { IntArray(7) }
        QuestionScreen(
            dataArray = dataArray,
            onClick = {  }
        )
    }
}