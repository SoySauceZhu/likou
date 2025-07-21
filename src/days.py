from datetime import datetime

def days_between(date1, date2):
    # Convert string dates to datetime objects
    d1 = datetime.strptime(date1, "%Y-%m-%d")
    d2 = datetime.strptime(date2, "%Y-%m-%d")
    
    # Calculate the difference
    delta = abs((d2 - d1).days)
    return delta

# Example usage
date1 = input("Enter first date (YYYY-MM-DD): ")
date2 = input("Enter second date (YYYY-MM-DD): ")

try:
    days = days_between(date1, date2)
    print(f"Days between the dates: {days}")
except ValueError:
    print("Invalid date format. Please use YYYY-MM-DD.")