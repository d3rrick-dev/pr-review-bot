import sys
import os
from openai import OpenAI

def generate_review(diff):
    client = OpenAI(api_key=os.getenv("OPENAI_API_KEY"))

    prompt = f"""
You are an expert senior software engineer reviewing code changes.

Review the following diff and provide:

- Bugs
- Security issues
- Concurrency issues
- SQL/Injection risks
- Performance problems
- Missing validation
- Code style issues
- Suggestions for improvement

Format as:

## 🔍 AI Code Review

### 🚨 Issues
- ...

### 💡 Suggestions
- ...

### 🧪 Recommended Tests
- ...

Here is the diff:

{diff}
    """

    response = client.chat.completions.create(
        model="gpt-4o-mini",
        messages=[{"role": "user", "content": prompt}]
    )

    return response.choices[0].message.content


if __name__ == "__main__":
    diff = sys.stdin.read()
    review = generate_review(diff)
    print(review)