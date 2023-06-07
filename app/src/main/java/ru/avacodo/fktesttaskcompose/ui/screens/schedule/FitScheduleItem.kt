package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.avacodo.fktesttaskcompose.R
import ru.avacodo.fktesttaskcompose.domain.model.FitLesson

@Preview
@Composable
fun FitScheduleItem(
    lesson: FitLesson = FitLesson(
        name = "Персональная тренировка",
        date = "среда, 11 января",
        tab = "mea",
        startTime = "16:45",
        endTime = "17:45",
        duration = "1 ч. 00 мин.",
        coachName = "Мишенин Даниил",
        place = "Тренажерный зал",
        markerColor = "#FF0000"
    )
) {


    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                modifier = Modifier
                    .height(50.dp)
                    .width(6.dp)
                    .background(Color(android.graphics.Color.parseColor(lesson.markerColor)))
            )
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                SecondaryText(text = lesson.startTime)
                SecondaryText(text = lesson.endTime)
            }
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier.padding(end = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PrimaryText(modifier = Modifier.weight(1f), text = lesson.name)
                    SecondaryText(text = lesson.duration)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(0.6f)
                    ) {
                        Icon(
                            modifier = Modifier.width(16.dp),
                            painter = painterResource(R.drawable.ic_coach),
                            contentDescription = "coach_icon"
                        )
                        SecondaryText(
                            modifier = Modifier.padding(start = 8.dp),
                            text = lesson.coachName
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            modifier = Modifier.width(16.dp),
                            painter = painterResource(R.drawable.ic_location),
                            contentDescription = "place_icon"
                        )
                        InfoText(
                            modifier = Modifier.padding(start = 8.dp),
                            text = lesson.place
                        )
                    }
                }
            }
        }
    }
}

private val primaryTextStyle: TextStyle = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp
)

private val secondaryTextStyle: TextStyle = TextStyle(
    fontSize = 12.sp
)

private val infoTextStyle: TextStyle = TextStyle(
    fontSize = 11.sp
)

@Composable
fun PrimaryText(modifier: Modifier, text: String) {
    Text(modifier = modifier, text = text, style = primaryTextStyle)
}

@Composable
fun SecondaryText(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = secondaryTextStyle)
}

@Composable
fun InfoText(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = infoTextStyle)
}
