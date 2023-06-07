package ru.avacodo.fktesttaskcompose.data.mapper

import ru.avacodo.fktesttaskcompose.data.dto.FitDataDto
import ru.avacodo.fktesttaskcompose.data.local.entity.FitLessonEntity
import ru.avacodo.fktesttaskcompose.domain.model.FitLesson
import ru.avacodo.fktesttaskcompose.domain.utils.TimeDurationCalc
import java.text.SimpleDateFormat
import java.util.Locale

private const val DEFAULT_TAB_NAME = "undefined tab name"
private const val DEFAULT_COACH_NAME = "undefined coach name"
private const val DATE_PATTERN = "yyyy-MM-dd"
private const val TIME_PATTERN = "HH:mm"
private const val DATE_PARSE_ERROR = "date parse error"
private const val TIME_PARSE_ERROR = "time parse error"

class FitDataMapper(private val durationCalc: TimeDurationCalc) : ModelsMapper {
    private val dateFormatter = SimpleDateFormat(DATE_PATTERN, Locale.getDefault())
    private val timeFormatter = SimpleDateFormat(TIME_PATTERN, Locale.getDefault())

    override fun mapToLessonList(data: FitDataDto): List<FitLesson> {
        return data.lessons.map { lesson ->
            with(lesson) {
                FitLesson(
                    name = name,
                    date = dateFormatter.parse(date) ?: error(DATE_PARSE_ERROR),
                    tab = data.tabs.find { it.id == tab_id }?.name
                        ?: DEFAULT_TAB_NAME,
                    startTime = timeFormatter.parse(startTime) ?: error(TIME_PARSE_ERROR),
                    endTime = timeFormatter.parse(endTime) ?: error(TIME_PARSE_ERROR),
                    duration = durationCalc.calcTimeDuration(startTime, endTime),
                    coachName = data.trainers.find { it.id == coach_id }?.full_name
                        ?: DEFAULT_COACH_NAME,
                    place = place,
                    markerColor = color
                )
            }
        }
    }

    override fun mapToLessonEntityList(data: FitDataDto): List<FitLessonEntity> {
        return data.lessons.map { lesson ->
            with(lesson) {
                FitLessonEntity(
                    appointmentID = appointment_id,
                    availableSlots = available_slots,
                    clientRecorded = client_recorded,
                    coachName = data.trainers.find { it.id == coach_id }?.full_name
                        ?: DEFAULT_COACH_NAME,
                    color = color,
                    commercial = commercial,
                    date = date,
                    description = description,
                    endTime = endTime,
                    isCancelled = is_cancelled,
                    name = name,
                    place = place,
                    serviceID = service_id,
                    startTime = startTime,
                    tab = tab,
                    tabID = tab_id
                )
            }
        }
    }

    override fun mapEntityToLesson(lessonEntity: FitLessonEntity): FitLesson {
        return with(lessonEntity) {
            FitLesson(
                name = name,
                date = dateFormatter.parse(date) ?: error(DATE_PARSE_ERROR),
                tab = tab,
                startTime = timeFormatter.parse(startTime) ?: error(TIME_PARSE_ERROR),
                endTime = timeFormatter.parse(endTime) ?: error(TIME_PARSE_ERROR),
                duration = durationCalc.calcTimeDuration(startTime, endTime),
                coachName = coachName,
                place = place,
                markerColor = color
            )
        }
    }
}