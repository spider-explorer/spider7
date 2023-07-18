if "%1" == "" (
  gradle run -q
) else (
  gradle run -q --args="%*"
)
