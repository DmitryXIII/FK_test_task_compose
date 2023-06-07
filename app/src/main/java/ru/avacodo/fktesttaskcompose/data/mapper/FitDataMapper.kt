package ru.avacodo.fktesttaskcompose.data.mapper

import ru.avacodo.fktesttaskcompose.data.dto.FitDataDto
import ru.avacodo.fktesttaskcompose.data.local.entity.FitLessonEntity
import ru.avacodo.fktesttaskcompose.domain.model.FitLesson
import ru.avacodo.fktesttaskcompose.domain.utils.TimeDurationCalc
import java.text.SimpleDateFormat
import java.util.Locale

private const val DEFAULT_TAB_NAME = "undefined tab name"
private const val DEFAULT_COACH_NAME = "undefined coach name"
private const val INCOME_DATE_PATTERN = "yyyy-MM-dd"
private const val OUTCOME_DATE_PATTERN = "EEEE, dd MMMM"
private const val DATE_PARSE_ERROR = "date parse error"

class FitDataMapper(private val durationCalc: TimeDurationCalc) : ModelsMapper {
    private val incomeDateFormatter = SimpleDateFormat(INCOME_DATE_PATTERN, Locale.getDefault())
    private val outcomeDateFormatter = SimpleDateFormat(OUTCOME_DATE_PATTERN, Locale.getDefault())

    override fun mapToLessonList(data: FitDataDto): List<FitLesson> {
        return data.lessons.map { lesson ->
            with(lesson) {
                FitLesson(
                    name = name,
                    date = outcomeDateFormatter.format(
                        incomeDateFormatter.parse(date) ?: error(
                            DATE_PARSE_ERROR
                        )
                    ),
                    tab = data.tabs.find { it.id == tab_id }?.name
                        ?: DEFAULT_TAB_NAME,
                    startTime = startTime,
                    endTime = endTime,
                    duration = durationCalc.calcTimeDuration(startTime, endTime),
                    coachName = data.trainers.find { it.id == coach_id }?.full_name
                        ?: DEFAULT_COACH_NAME,
                    place = place,
                    markerColor = color
                )
            }
        }
    }

    override fun mapToLessonEntity(lesson: FitLesson): FitLessonEntity {
        return with(lesson) {
            FitLessonEntity(
                name = name,
                date = date,
                tab = tab,
                startTime = startTime,
                endTime = endTime,
                duration = duration,
                coachName = coachName,
                place = place,
                markerColor = markerColor
            )
        }
    }

    override fun mapEntityToLesson(lessonEntity: FitLessonEntity): FitLesson {
        return with(lessonEntity) {
            FitLesson(
                name = name,
                date = date,
                tab = tab,
                startTime = startTime,
                endTime = endTime,
                duration = duration,
                coachName = coachName,
                place = place,
                markerColor = markerColor
            )
        }
    }
}