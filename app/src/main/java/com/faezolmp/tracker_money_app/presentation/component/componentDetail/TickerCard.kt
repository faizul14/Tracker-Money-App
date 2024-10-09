import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TicketCardWithTearEffect() {
    Surface(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(), // Allow height to adjust
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.Cyan)

        ) {
            // Top Section: Image or Icon Placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.size(100.dp)) {
                    drawCircle(
                        color = Color.Gray,
                        style = Stroke(width = 4.dp.toPx())
                    )
                }
            }

            // Middle Section: Event Information
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Ticket UI Using Compose",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Organiser",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
                        .padding(8.dp)
                        .fillMaxWidth()
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "26-Jun-2024 • 5:30 am",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Online event",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
            }

            // Dotted line
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            ) {
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 2f
                )
            }

            // Bottom Section: Ticket Holder Information
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Karishma Agrawal",
                        fontSize = 18.sp
                    )
                    Text(
                        text = "Tier 1 Class 1",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
                Text(
                    text = "1 of 4",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            // Bottom Tear Effect
            Box(modifier = Modifier.fillMaxWidth().height(30.dp)) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val circleRadius = 20.dp.toPx() // Adjust radius of the half-circle
                    val numberOfCircles = (size.width / (circleRadius * 2)).toInt() // Calculate number of circles
                    val path = Path()

                    // Draw semi-circle tear effect
                    for (i in 0 until numberOfCircles) {
                        val left = i * circleRadius * 2
                        val top = 0f
                        val right = left + circleRadius * 2
                        val bottom = circleRadius * 2

                        path.addArc(
                            Rect(
                                left = left,
                                top = top,
                                right = right,
                                bottom = bottom
                            ),
                            startAngleDegrees = 180f,
                            sweepAngleDegrees = 180f
                        )
                    }

                    // Draw the path with background color to simulate tear
                    drawPath(path, color = Color.White, style = Fill) // Background Color
                    drawPath(path, color = Color.Gray, style = Stroke(2f)) // Border
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TicketCardWithTearEffectPreview() {
    TicketCardWithTearEffect()
}
